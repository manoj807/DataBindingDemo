package com.valleytech.databindingdemo.composeui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme
import com.valleytech.databindingdemo.BasicBindingActivity
import com.valleytech.databindingdemo.OneWayDataBindingActivity
import com.valleytech.databindingdemo.utils.intent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MessageList(getDataBindingList())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeAppTheme {
        MessageList(getDataBindingList())
    }
}


@Composable
fun MessageList(messages: List<String>) {
    val contex= LocalContext.current
    Column(modifier = Modifier.padding(vertical = 4.dp)){

        messages.forEachIndexed { index, message ->
            MessageRow(message,index){ message, index ->
             when(index){
                0->{
                  val intent= contex.intent<BasicBindingActivity>()
                    contex.startActivity(intent)
                }
                 1->{
                     val intent= contex.intent<OneWayDataBindingActivity>()
                     contex.startActivity(intent)
                 }
                 else->{
                     Toast.makeText(contex,"Item not response", Toast.LENGTH_LONG)
                 }


             }
            }
        }

    }
}


@Composable
private fun MessageRow(name: String,index:Int, onClick: (msg: String,index:Int) -> Unit) {
    val msg = "Hello, $name"

    Card(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable { onClick(msg,index) }
    ) {
        Row(modifier = Modifier.padding(12.dp).fillMaxWidth()) {
            Column {
                Text(text = name, modifier = Modifier.padding(15.dp))

            }
        }
    }
}

/*@Composable
fun MessageRow(message: String) {
    
    Row(modifier = Modifier.selectable(onClick = {

    })){
         Column {
             Text(text = message, modifier = Modifier.padding(15.dp))

             Divider()
          }
        }


}*/


fun getDataBindingList():List<String>
{

    return listOf("Basic Data Binding",
               "One Way Data Binding"
             )

}