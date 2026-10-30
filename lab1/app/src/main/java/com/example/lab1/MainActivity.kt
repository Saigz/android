package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen() {

    val backgroundColor = Color(0xFFF2F5FA)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Карточка пользователя
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp,
                    Color(0xFFDCE4EF),
                    RoundedCornerShape(14.dp)
                ),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {

                // Аватар
                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .background(
                            Color(0xFFE0E9F9),
                            CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(3.dp)
                    ) {

                        // Голова
                        Box(
                            modifier = Modifier
                                .size(17.dp)
                                .background(
                                    Color(0xFF8298BA),
                                    CircleShape
                                )
                        )

                        // Тело
                        Box(
                            modifier = Modifier
                                .width(34.dp)
                                .height(18.dp)
                                .background(
                                    Color(0xFF8298BA),
                                    RoundedCornerShape(
                                        topStart = 18.dp,
                                        topEnd = 18.dp
                                    )
                                )
                        )
                    }
                }

                // Имя
                Text(
                    text = "Алексей",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF17243A)
                )

                // Профессия
                Text(
                    text = "Android Dev",
                    fontSize = 13.sp,
                    color = Color(0xFF34445D)
                )

                // Город и возраст
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Москва",
                        fontSize = 12.sp,
                        color = Color(0xFF53627A)
                    )

                    Text(
                        text = "|",
                        fontSize = 16.sp,
                        color = Color(0xFFD5DDE8)
                    )

                    Text(
                        text = "25 лет",
                        fontSize = 12.sp,
                        color = Color(0xFF53627A)
                    )
                }
            }
        }
    }
}
