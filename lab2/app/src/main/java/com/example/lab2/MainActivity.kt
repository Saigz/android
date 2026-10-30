package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TemperatureScreen()
        }
    }
}

@Composable
fun TemperatureScreen() {

    var temperature by remember { mutableIntStateOf(22) }

    val status = when {
        temperature > 25 -> "Жарко"
        temperature < 20 -> "Прохладно"
        else -> "Комфортная температура"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F5FA))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Text(
                    text = "Температура",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "$temperature °C",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    // Уменьшение температуры
                    Box(
                        modifier = Modifier
                            .size(55.dp)
                            .background(
                                Color(0xFFE8EFFB),
                                RoundedCornerShape(12.dp)
                            )
                            .clickable {
                                if (temperature > 16) temperature--
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "−",
                            fontSize = 24.sp,
                            color = Color(0xFF17243A)
                        )
                    }

                    // Увеличение температуры
                    Box(
                        modifier = Modifier
                            .size(55.dp)
                            .background(
                                Color(0xFF3685F5),
                                RoundedCornerShape(12.dp)
                            )
                            .clickable {
                                if (temperature < 30) temperature++
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "+",
                            fontSize = 24.sp,
                            color = Color.White
                        )
                    }
                }

                // Статус температуры
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color(0xFFE8F0FF),
                            RoundedCornerShape(12.dp)
                        )
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = status,
                        fontSize = 14.sp,
                        color = Color(0xFF263E69)
                    )
                }
            }
        }
    }
}
