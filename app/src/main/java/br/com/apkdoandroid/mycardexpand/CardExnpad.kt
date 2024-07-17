package br.com.apkdoandroid.mycardexpand

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.apkdoandroid.mycardexpand.ui.theme.Azul

@Composable
fun CardExpand( modifier: Modifier = Modifier) {
    var expandad by remember{ mutableStateOf(false) }
    val rotacao by animateFloatAsState(
        targetValue = if(expandad) 180f else 0f ,
        animationSpec = tween(durationMillis = 500),
        label = ""
    )
    Card (
        modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Azul)
                    .padding(16.dp)
            ) {
                Text(text = "Agendamento",
                    style = TextStyle(Color.White.copy(0.8f))
                )

                Spacer(modifier = Modifier.height(16.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(painter = painterResource(id = R.drawable.ic_time),
                        contentDescription = null, tint = Color.White )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "16 de Julho de 2024 ás 18:00",
                        style = TextStyle(Color.White))
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        tween(
                            durationMillis = 500,
                            easing = LinearOutSlowInEasing
                        )
                    )

            ) {
                if(expandad){
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            modifier = Modifier
                                .size(70.dp)
                                .clip(RoundedCornerShape(24.dp)),
                            painter = painterResource(id = R.drawable.elanilson),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(text = "Elanilson de Jesus",
                                style = TextStyle(Color.Black))
                            Text(text = "28 anos",
                                style = TextStyle(Color.Black))
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row ( modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically){
                        Button(
                            modifier =Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Azul
                            ),
                            onClick = {  }) {
                            Text(text = "Aceitar",
                                style = TextStyle(Color.White))
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            modifier =Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White
                            ),
                            onClick = {  }) {
                            Text(text = "Recursar",
                                style = TextStyle(Azul))
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expandad = !expandad },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = if (expandad) "Ver menos" else "Ver mais",
                    style = TextStyle(Azul), fontWeight = FontWeight.Medium)
                Icon(
                    modifier = Modifier.rotate(rotacao),
                    painter = painterResource(id = R.drawable.ic__arrow_down_24),
                    contentDescription = null, tint = Azul )
            }
        }
    )

}

@Preview(showBackground = true)
@Composable
fun CardExpandPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardExpand()
    }
}