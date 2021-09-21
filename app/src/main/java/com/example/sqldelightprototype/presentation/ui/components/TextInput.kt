package com.example.sqldelightprototype.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sqldelightprototype.R
import com.example.sqldelightprototype.presentation.models.ErrorState
import com.example.sqldelightprototype.presentation.ui.theme.SqlDelightPrototypeTheme

@Composable
fun TextInput(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    label: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    keyboardActions: KeyboardActions = KeyboardActions { },
    errorState: ErrorState = ErrorState(error = false)
) {
    Column(modifier = modifier) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = onTextChange,
            label = {
                label?.let {
                    Text(it)
                }
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            isError = errorState.error
        )
        if (errorState.error && errorState.messageResource != null) {
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = stringResource(errorState.messageResource),
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Preview
@Composable
fun TextInputPreview() {
    SqlDelightPrototypeTheme {
        TextInput(
            text = "Test",
            onTextChange = {},
            label = "label",
            errorState = ErrorState(error = true, messageResource = R.string.error_blank_name)
        )
    }
}