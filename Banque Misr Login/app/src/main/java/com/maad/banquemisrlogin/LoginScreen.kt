package com.maad.banquemisrlogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maad.banquemisrlogin.ui.theme.Red
import com.maad.banquemisrlogin.ui.theme.RedOff
import com.maad.banquemisrlogin.ui.theme.White

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .padding(start = 16.dp, end = 16.dp, top = 40.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        LoginHeader()
        LoginFields()
        BanqueServices()
    }

}

@Composable
fun LoginHeader(modifier: Modifier = Modifier) {
    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.bm_icon),
            contentDescription = stringResource(R.string.banque_misr_logo),
            modifier = Modifier.size(128.dp)
        )
        Text(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Red,
            text = stringResource(R.string.change_language_to)
        )
    }
}

@Composable
fun LoginFields(modifier: Modifier = Modifier) {
    var usernameField by remember { mutableStateOf("") }
    OutlinedTextField(
        value = usernameField,
        onValueChange = {
            usernameField = it
        },
        label = {
            Text(
                text = stringResource(R.string.username), color = Color.Gray,
                fontWeight = FontWeight.Medium
            )
        },
        modifier = modifier.fillMaxWidth()
    )
    var passwordField by remember { mutableStateOf("") }
    var isPasswordShown by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = passwordField,
        onValueChange = {
            passwordField = it
        },
        label = {
            Text(
                text = stringResource(R.string.password),
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            )
        },
        visualTransformation = if (isPasswordShown) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (isPasswordShown)
                R.drawable.ic_visibility_on
            else R.drawable.ic_visibility_off

            IconButton(onClick = {
                isPasswordShown = !isPasswordShown
            }) {
                Icon(
                    painter = painterResource(id = image),
                    contentDescription = stringResource(R.string.password_toggle)
                )
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
    )
    Text(
        text = stringResource(R.string.forgot_username_password),
        textDecoration = TextDecoration.Underline,
        fontSize = 12.sp,
        modifier = modifier.padding(top = 16.dp)
    )
    Button(
        onClick = { },
        colors = ButtonDefaults
            .buttonColors(
                containerColor = Red,
                disabledContainerColor = RedOff,
                disabledContentColor = White
            ),
        enabled = usernameField.isNotBlank() && passwordField.isNotBlank(),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .padding(top = 32.dp)
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Text(text = stringResource(R.string.login), fontSize = 16.sp)
    }
    Text(text = buildAnnotatedString {
        append(stringResource(R.string.need_help))
        withStyle(
            style = SpanStyle(
                color = Red,
                fontWeight = FontWeight.Medium,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(stringResource(R.string.contact_us))
        }
    }, fontSize = 16.sp, modifier = modifier.padding(top = 12.dp))
    Divider(modifier.padding(top = 40.dp))
}

@Composable
fun BanqueServices(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
    ) {
        BanqueServiceItem(
            image = R.drawable.our_products,
            service = stringResource(R.string.our_products)
        )
        BanqueServiceItem(
            image = R.drawable.exchange_rate,
            service = stringResource(R.string.exchange_rate)
        )
        BanqueServiceItem(
            image = R.drawable.security_tips,
            service = stringResource(R.string.security_tips)
        )
        BanqueServiceItem(
            image = R.drawable.nearest_branch_or_atm,
            service = stringResource(R.string.nearest_branch_or_atm)
        )
    }
}

@Composable
fun BanqueServiceItem(image: Int, service: String, modifier: Modifier = Modifier) {
    Column {
        Image(
            painter = painterResource(id = image),
            contentDescription = service,
            modifier = modifier.size(68.dp)
        )
        Text(
            text = service, textAlign = TextAlign.Center, fontSize = 14.sp,
            modifier = modifier.width(68.dp)
        )
    }
}

@Preview(showBackground = true, locale = "ar")
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}