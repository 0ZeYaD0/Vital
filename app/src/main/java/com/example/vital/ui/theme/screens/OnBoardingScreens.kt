package com.example.vital.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.vital.ui.theme.*

@Composable
fun OnboardingScreen(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundCream)  // ✅ Ensure BackgroundCream is defined
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            // Device Image
            Image(
                painter = rememberAsyncImagePainter("https://cdn.builder.io/api/v1/image/assets/TEMP/5c2532a2894376cf08043f205f5986af3693bb8d"),
                contentDescription = "Device",
                modifier = Modifier
                    .padding(top = 186.dp)
                    .width(screenWidth * 0.9f)  // ✅ Dynamic width
                    .aspectRatio(432f / 264f),
                contentScale = ContentScale.Fit
            )

            // Dots Indicator
            Row(
                horizontalArrangement = Arrangement.spacedBy(9.dp),
                modifier = Modifier.padding(top = 48.dp)
            ) {
                listOf(DotGray, DotDark, DotGray).forEach { color ->
                    Box(
                        modifier = Modifier
                            .width(25.dp)
                            .height(4.dp)
                            .clip(RoundedCornerShape(17.dp))
                            .background(color)  // ✅ Ensure DotGray & DotDark are defined
                    )
                }
            }

            // Vita Logo
            Image(
                painter = rememberAsyncImagePainter("https://cdn.builder.io/api/v1/image/assets/TEMP/559abc08fb7e354a8a9b2d68bb0c3320896b376a"),
                contentDescription = "Vita Logo",
                modifier = Modifier
                    .padding(top = 4.dp)
                    .width(266.dp)
                    .height(137.dp)
                    .shadow(elevation = 4.dp)
            )

            // Heading
            Text(
                text = "Always Monitor Your Glucose Level.",
                style = Typography.headlineMedium,
                modifier = Modifier
                    .padding(top = 6.dp)
                    .width(323.dp)
            )

            // Description
            Text(
                text = "Monitor your glucose levels with ease. Stay healthy and informed at all times.",
                style = Typography.bodyLarge,
                modifier = Modifier
                    .padding(top = 21.dp)
                    .width(267.dp)
            )

            // Buttons
            Column(
                verticalArrangement = Arrangement.spacedBy(11.dp),
                modifier = Modifier
                    .padding(top = 11.dp)
                    .width(231.dp)
            ) {
                CustomButton(
                    text = "Log In",
                    backgroundColor = NavyBlue,  // ✅ Ensure NavyBlue is defined
                    onClick = onLoginClick
                )

                CustomButton(
                    text = "Sign Up",
                    backgroundColor = TurquoiseGreen,  // ✅ Ensure TurquoiseGreen is defined
                    onClick = onSignUpClick
                )
            }
        }
    }
}
