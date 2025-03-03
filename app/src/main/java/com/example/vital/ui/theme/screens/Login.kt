package com.example.vital.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vital.ui.theme.*
import androidx.compose.ui.text.font.FontWeight

@Composable
fun LoginScreen(navController: NavController) {  // ✅ NavController added
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = 40.dp, vertical = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            style = AppTypography.headlineLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(50.dp))

        CustomInput(
            value = email,
            onValueChange = { email = it },
            placeholder = "Email"
        )

        Spacer(modifier = Modifier.height(25.dp))

        CustomInput(
            value = password,
            onValueChange = { password = it },
            placeholder = "Password",
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = buildAnnotatedString {
                append("By continuing, you agree to\n")
                withStyle(SpanStyle(color = LinkBlue, fontWeight = FontWeight.Medium)) {
                    append("Terms of Use")
                }
                append(" and ")
                withStyle(SpanStyle(color = LinkBlue, fontWeight = FontWeight.Medium)) {
                    append("Privacy Policy.")
                }
            },
            style = AppTypography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(270.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                navController.navigate("home")  // ✅ Navigate to home screen
            },
            modifier = Modifier
                .width(220.dp)
                .clip(RoundedCornerShape(15.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
        ) {
            Text(
                text = "Sign in",
                style = AppTypography.bodyLarge.copy(
                    color = White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "or sign in with",
            style = AppTypography.bodyMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.width(100.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            repeat(3) { index ->
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Social Login",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            navController.navigate("social_login/${index + 1}") // ✅ Navigate to social login screen
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.width(200.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Forgot your password?",
                style = AppTypography.bodySmall
            )
            Text(
                text = " Reset here",
                style = AppTypography.bodySmall.copy(color = ResetBlue),
                modifier = Modifier.clickable { navController.navigate("reset_password") }, // ✅ Navigate to reset password
                textDecoration = TextDecoration.Underline
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Don't have an account? Sign up",
            style = AppTypography.bodySmall.copy(color = PrimaryBlue),
            textAlign = TextAlign.Center
        )
    }
}
