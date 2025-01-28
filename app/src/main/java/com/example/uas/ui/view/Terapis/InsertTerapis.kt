//package com.example.uas.ui.view.Terapis
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun InsertTerapisView(
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
//                title = "Insert Terapis",
//                canNavigateBack = true,
//                scrollBehavior = scrollBehavior,
//                navigateUp = navigateBack
//            )
//        }
//    ) { innerPadding ->
//        EntryBody(
//            insertUiState = viewModel.uiState,
//            onSiswaValueChange = viewModel::updateInsertTerapisState,
//            onSaveClick = {
//                coroutineScope.launch {
//                    viewModel.insertTerapis()
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
