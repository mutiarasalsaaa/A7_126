package com.example.uas.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uas.R
import com.example.uas.ui.navigation.destinasiNavigasi

object DestinasiHome : destinasiNavigasi {
    override val route = "dashboard"
    override val titleRes = "Dashboard"
}

@Composable
fun HomeMenuView(
    onJenisClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFEDE7F6), Color(0xFFBB86FC))
                )
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Logo aplikasi tanpa header putih
        Image(
            painter = painterResource(id = R.drawable.logoterapi),
            contentDescription = "App Logo",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Kartu menu modern dengan beberapa pilihan tombol
        MenuCardWithButtons(
            title = "Menu Utama",
            description = "Silahkan pilih salah satu menu yang anda butuhkan untuk melanjutkan",
            icon = Icons.Filled.ShoppingCart,
            buttons = listOf("Jenis Terapi", "Pasien", "Sesi Terapi", "Terapis"),
            onClick = onJenisClick
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun MenuCardWithButtons(
    title: String,
    description: String,
    icon: ImageVector,
    buttons: List<String>,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = Color(0xFFBB86FC)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFEDE7F6))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = Color(0xFF3700B3)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF3700B3),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF6200EE),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            buttons.forEach { buttonLabel ->
                Button(
                    onClick = onClick,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Text(text = buttonLabel, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeMenuViewPreview() {
    HomeMenuView(onJenisClick = {})
}
