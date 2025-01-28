//package com.example.uas.ui.view.Terapis
//
//@Composable
//fun EntryBodyTerapis(
//    insertUiState: InsertUiStateTerapis,
//    onTerapisValueChange: (String, String) -> Unit,
//    onSaveClick: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    Column(
//        modifier = modifier.padding(16.dp)
//    ) {
//        TextField(
//            value = insertUiState.namaTerapis,
//            onValueChange = { onTerapisValueChange("namaTerapis", it) },
//            label = { Text("Nama Terapis") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        TextField(
//            value = insertUiState.spesialisasi,
//            onValueChange = { onTerapisValueChange("spesialisasi", it) },
//            label = { Text("Spesialisasi") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        TextField(
//            value = insertUiState.jenisKelamin,
//            onValueChange = { onTerapisValueChange("jenisKelamin", it) },
//            label = { Text("Jenis Kelamin") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        TextField(
//            value = insertUiState.nomorHp,
//            onValueChange = { onTerapisValueChange("nomorHp", it) },
//            label = { Text("Nomor HP") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        TextField(
//            value = insertUiState.alamat,
//            onValueChange = { onTerapisValueChange("alamat", it) },
//            label = { Text("Alamat") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(
//            onClick = onSaveClick,
//            modifier = Modifier.align(Alignment.End)
//        ) {
//            Text("Simpan")
//        }
//    }
//}
