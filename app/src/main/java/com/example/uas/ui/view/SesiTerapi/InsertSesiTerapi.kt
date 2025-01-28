//package com.example.uas.ui.view.SesiTerapi
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun InsertSesiterapisView(
//    navigateBack: () -> Unit,
//    modifier: Modifier = Modifier,
//    viewModel: InsertViewModel
//) {
//    val coroutineScope = rememberCoroutineScope()
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
//
//    Scaffold(
//        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
//        topBar = {
//            CostumeTopAppBar(
//                title = "Insert Sesi Terapis",
//                canNavigateBack = true,
//                scrollBehavior = scrollBehavior,
//                navigateUp = navigateBack
//            )
//        }
//    ) { innerPadding ->
//        EntryBody(
//            insertUiState = viewModel.uiState,
//            onSiswaValueChange = viewModel::updateInsertSesiterapisState,
//            onSaveClick = {
//                coroutineScope.launch {
//                    viewModel.insertSesiterapis()
//                    navigateBack()
//                }
//            },
//            modifier = Modifier
//                .padding(innerPadding)
//                .verticalScroll(rememberScrollState())
//                .fillMaxWidth()
//        )
//    }
//}
