//package com.example.uas.ui.view.SesiTerapi
//
//@Composable
//fun EntryBodySesiTerapis(
//    insertUiState: InsertUiStateSesiTerapis,
//    onSesiTerapisValueChange: (String, String) -> Unit,
//    onSaveClick: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    Column(
//        modifier = modifier.padding(16.dp)
//    ) {
//        TextField(
//            value = insertUiState.namaTerapis,
//            onValueChange = { onSesiTerapisValueChange("namaTerapis", it) },
//            label = { Text("Nama Terapis") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        TextField(
//            value = insertUiState.jenisSesi,
//            onValueChange = { onSesiTerapisValueChange("jenisSesi", it) },
//            label = { Text("Jenis Sesi") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        TextField(
//            value = insertUiState.waktuMulai,
//            onValueChange = { onSesiTerapisValueChange("waktuMulai", it) },
//            label = { Text("Waktu Mulai") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        TextField(
//            value = insertUiState.waktuSelesai,
//            onValueChange = { onSesiTerapisValueChange("waktuSelesai", it) },
//            label = { Text("Waktu Selesai") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        TextField(
//            value = insertUiState.catatan,
//            onValueChange = { onSesiTerapisValueChange("catatan", it) },
//            label = { Text("Catatan") },
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
