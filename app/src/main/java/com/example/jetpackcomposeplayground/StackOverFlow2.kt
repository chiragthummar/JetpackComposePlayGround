package com.example.jetpackcomposeplayground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PlayScreenPreview2() {
    OrderChequeRequestScreen()
}


@Composable
fun OrderChequeRequestScreen() {
    var selectedDropdownItem by remember { mutableStateOf("Item 1") }
    val dropdownItems = listOf("Item 1", "Item 2", "Item 3")
    var isDropdownExpanded by remember { mutableStateOf(false) }

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                TextField(
                    value = selectedDropdownItem,
                    onValueChange = { selectedDropdownItem = it },
                    label = { Text("Select an item") },
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = {
                        IconButton(
                            onClick = { isDropdownExpanded = !isDropdownExpanded },
                        ) {
                            Icon(
                                if (isDropdownExpanded) Icons.Default.Close else Icons.Default.Search,
                                contentDescription = null,
                            )
                        }
                    },
                )

                DropdownMenu(
                    expanded = isDropdownExpanded,
                    onDismissRequest = { isDropdownExpanded = false },
                ) {
                    dropdownItems.forEach { item ->
                        DropdownMenuItem(
                            onClick = {
                                selectedDropdownItem = item
                                isDropdownExpanded = false
                            },
                        ) {
                            Text(text = item)
                        }
                    }
                }
            }
        },
    )
}