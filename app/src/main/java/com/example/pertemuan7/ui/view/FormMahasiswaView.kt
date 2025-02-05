package com.example.pertemuan7.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier

@Composable
fun FormMahasiswa(
    modifier: Modifier = Modifier,
    listJk: List<String>,
    onSubmitClicked: (MutableList<String>) -> Unit
){
    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var selectGender by remember { mutableStateOf("") }

    val dataMahasiswa: MutableList<String> = mutableListOf(nama, nim, selectGender, alamat, email, noHp)

    Column(modifier.fillMaxSize().padding(16.dp).padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            placeholder = { Text("Masukan Nama") },
            label = { Text("Nama") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = nim, onValueChange = { nim = it },
            placeholder = { Text("Masukan NIM anda") },
            label = { Text("NIM") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            listJk.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectGender == item,
                        onClick = {
                            selectGender = item
                        }
                    )
                    Text(item)
                }

            }
        }
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Masukan Email") },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        OutlinedTextField(
            value = alamat, onValueChange = { alamat = it },
            placeholder = {
                Text("Masukan Alamat")
            },
            label = { Text("Alamat") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = noHp, onValueChange = { noHp = it },
            placeholder = { Text("Masukan No Hp") },
            label = { Text("No HP") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick =  { onSubmitClicked(dataMahasiswa)

        })
        {
            Text("Submit")
        }
    }
}




