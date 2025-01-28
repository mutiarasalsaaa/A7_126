package com.example.uas.ui.view.JenisTerapis

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalpam.ui.viewmodel.jenisTerapis.HomeJenisTerapisUiState
import com.example.finalpam.ui.viewmodel.jenisTerapis.HomeJenisTerapisViewModel
import com.example.uas.R
import com.example.uas.model.JenisTerapis
import com.example.uas.ui.customwidget.CostumeTopAppBar
import com.example.uas.ui.navigation.destinasiNavigasi
import com.example.uas.ui.viewmodel.PenyediaViewModel

object  DestinasiHomeJenisTerapis  : destinasiNavigasi {
    override val  route  =  "homejenisTerapis"
    override val  titleRes  =  "Home JenisTerapis"
}

@OptIn ( ExperimentalMaterial3Api ::class )
@Composable
fun  HomeJenisTerapisScreen (
    navigateToItemEntry :  ()  ->  Unit,
    modifier : Modifier =  Modifier,
    onDetailClick :  ( String )  ->  Unit  =  {},
    viewModel : HomeJenisTerapisViewModel =  viewModel ( factory =  PenyediaViewModel .Factory)
) {
    val  scrollBehavior  =  TopAppBarDefaults . enterAlwaysScrollBehavior ()
    Scaffold (
        modifier =  modifier . nestedScroll ( scrollBehavior .nestedScrollConnection),
        topBar =  {
            CostumeTopAppBar (
                title =  DestinasiHomeJenisTerapis .titleRes,
                canNavigateBack =  false ,
                scrollBehavior =  scrollBehavior ,
                onRefresh =  {
                    viewModel . getJns ()
                }
            )
        } ,
        floatingActionButton =  {
            FloatingActionButton (
                onClick =  navigateToItemEntry ,
                shape =  MaterialTheme . shapes .medium,
                modifier =  Modifier . padding ( 18 . dp )
            )  {
                Icon ( imageVector =  Icons .Default. Add ,  contentDescription =  "Add Kontak" )

            }
        } ,
    )  {  innerPadding  ->
        HomeStatus (
            homeUiState =  viewModel .jnsUIState,
            retryAction =  {  viewModel . getJns ()  } ,  modifier =  Modifier . padding ( innerPadding ),
            onDetailClick =  onDetailClick ,  onDeleteClick =  {
                viewModel . deleteJns ( it .id_jenis_terapis   )
                viewModel . getJns ()
            }
        )

    }


}

@Composable
fun  HomeStatus (
    homeUiState : HomeJenisTerapisUiState,
    retryAction :  ()  ->  Unit,
    modifier : Modifier =  Modifier,
    onDeleteClick :  (JenisTerapis)  ->  Unit  =  {},
    onDetailClick :  ( String )  ->  Unit
) {

    when  ( homeUiState ) {
        is  HomeJenisTerapisUiState. Loading  ->  OnLoading ( modifier =  modifier . fillMaxSize ())

        is  HomeJenisTerapisUiState. Success  ->
            if  ( homeUiState .jenisTerapis. isEmpty ()){
                return  Box ( modifier =  modifier . fillMaxSize (),  contentAlignment =  Alignment .Center)  {
                    Text ( text =  "Tidak ada data Kontak"  )

                }
            } else  {
                JnsLayout (

                    jenisTerapis =  homeUiState .jenisTerapis,  modifier =  modifier . fillMaxWidth (),
                    onDetailClick =  {
                        onDetailClick ( it .id_jenis_terapis)
                    },
                    onDeleteClick =  {
                        onDeleteClick ( it )
                    }
                )
            }
        is  HomeJenisTerapisUiState. Error  ->  OnError ( retryAction ,  modifier =  modifier . fillMaxSize ())
    }

}

@Composable
fun  OnLoading ( modifier : Modifier =  Modifier ) {
    Image (
        modifier =  modifier.size ( 200 . dp ),
        painter =  painterResource ( R.drawable.loading_img),
        contentDescription =  stringResource ( R.string.loading )
    )
}

@Composable
fun  OnError ( retryAction :  ()  ->  Unit ,  modifier : Modifier =  Modifier ) {
    Column (
        modifier =  modifier ,
        verticalArrangement =  Arrangement .Center,
        horizontalAlignment =  Alignment .CenterHorizontally
    )  {
        Image (
            painter =  painterResource ( id =  R . drawable . ic_connection_error ),  contentDescription =  ""
        )
        Text ( text =  stringResource ( R . string . loading_failed ),  modifier =  Modifier . padding ( 16 . dp ))
        Button ( onClick =  retryAction )  {
            Text ( stringResource ( R . string . retry ))
        }
    }
}

@Composable
fun  JnsLayout (
    jenisTerapis :  List <JenisTerapis>,
    modifier : Modifier =  Modifier,
    onDetailClick :  (JenisTerapis)  ->  Unit,
    onDeleteClick :  (JenisTerapis)  ->  Unit  =  {}
) {
    LazyColumn (
        modifier =  modifier ,
        contentPadding =  PaddingValues ( 16 . dp ),
        verticalArrangement =  Arrangement . spacedBy ( 16 . dp )
    )  {
        items(jenisTerapis) { jns ->
            JnsCard(
                jenisTerapis = jns,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onDetailClick(jns) },
                onDeleteClick = {
                    onDeleteClick(jns)
                }
            )
        }

    }

}

@Composable
fun  JnsCard (
    jenisTerapis : JenisTerapis,
    modifier : Modifier =  Modifier,
    onDeleteClick :  (JenisTerapis)  ->  Unit  =  {}
) {
    Card (
        modifier =  modifier ,
        shape =  MaterialTheme . shapes .medium,
        elevation =  CardDefaults . cardElevation ( defaultElevation =  8 . dp )
    )  {
        Column (
            modifier =  Modifier . padding ( 16 . dp ),
            verticalArrangement =  Arrangement . spacedBy ( 8 . dp )
        )  {
            Row (
                modifier =  Modifier . fillMaxWidth (),
                verticalAlignment =  Alignment .CenterVertically
            )  {
                Text (
                    text =  jenisTerapis .id_jenis_terapis,
                    style =  MaterialTheme . typography .titleLarge,

                    )
                Spacer ( Modifier . weight ( 1f ))
                IconButton ( onClick =  {  onDeleteClick ( jenisTerapis )  } )  {
                    Icon (
                        imageVector =  Icons .Default. Delete ,
                        contentDescription =  null ,
                    )
                }
                Text (
                    text =  jenisTerapis .nama_jenis_terapi,
                    style =  MaterialTheme . typography .titleMedium
                )
            }

            Text (
                text =  jenisTerapis .deskripsi_terapi,
                style =  MaterialTheme . typography .titleMedium
            )
        }

    }
}