package com.example.jetpackcomposeplayground
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JetchatDrawer(
    drawerState: DrawerState = rememberDrawerState(initialValue = Closed),
    onProfileClicked: (String) -> Unit,
    onChatClicked: (String) -> Unit,
    content: @Composable () -> Unit
) {
    JetpackComposePlayGroundTheme {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    JetchatDrawerContent(
                        onProfileClicked = onProfileClicked,
                        onChatClicked = onChatClicked
                    )
                }
            },
            content = content
        )
    }
}
