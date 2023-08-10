package com.valleytech.databindingdemo.composeui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme
import com.valleytech.databindingdemo.basicdatabinding.BasicBindingActivity
import com.valleytech.databindingdemo.databindingwithviewmodel.DatabindingWithViewModelActivity
import com.valleytech.databindingdemo.livedatabinding.LiveDatabindingActivity
import com.valleytech.databindingdemo.objectdatabinding.ObjectDatabindingActivity
import com.valleytech.databindingdemo.observerfield.DatabindingWithObserverFieldActivity
import com.valleytech.databindingdemo.onewaydatabinding.OneWayDataBindingActivity
import com.valleytech.databindingdemo.recycleview.ui.RecycleViewDataBindingActivity
import com.valleytech.databindingdemo.twowaydatabinding.TwoWayDataBindActivity
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
                 2->{
                     val intent= contex.intent<DatabindingWithViewModelActivity>()
                     contex.startActivity(intent)
                 }

                 3->{
                     val intent= contex.intent<DatabindingWithObserverFieldActivity>()
                     contex.startActivity(intent)
                 }
                 4->{
                     val intent= contex.intent<ObjectDatabindingActivity>()
                     contex.startActivity(intent)
                 }



                 5->{
                     val intent= contex.intent<LiveDatabindingActivity>()
                     contex.startActivity(intent)
                 }
                 6->{
                     val intent= contex.intent<RecycleViewDataBindingActivity>()
                     contex.startActivity(intent)
                 }
                 7->{
                     val intent= contex.intent<TwoWayDataBindActivity>()
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
               "One Way Data Binding",

                "Data Binding with ViewModel",
                 "Data Binding with Observer Field",
        "Data Binding with Object Databinding",
        "Data Binding with Live Data",
        "Data Binding with Recycleview",
        "Two Way DataBinding"
             )

}