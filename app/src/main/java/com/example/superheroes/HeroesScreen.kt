@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.superheroes

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superheroes.data.HeroesRepository
import com.example.superheroes.model.Hero


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HeroApp() {
    Scaffold(
        topBar = { TopBar() },

        ) {
        HeroesList(Modifier.padding(it))
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(R.string.super_heroes),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    })
}

@Composable
fun HeroesList(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(HeroesRepository.heroes) {
            HeroCard(hero = it)
        }
    }
}

@Composable
fun HeroCard(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(
                vertical = dimensionResource(id = R.dimen.padding_extra_small),
                horizontal = dimensionResource(
                    id = R.dimen.padding_medium
                )
            ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .fillMaxWidth()
        ) {
            HeroData(hero = hero)
            HeroImage(hero = hero)

        }
    }
}

@Composable
fun HeroImage(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = hero.imageRes),
        contentDescription = null,
        modifier = modifier
//            .background(Color.Blue)
            .size(72.dp)
            .clip(shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_small))),
        contentScale = ContentScale.Crop,

        )
}

@Composable
fun HeroData(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
//            .background(Color.Red)
            .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
            .fillMaxWidth(.75f)

    ) {
        Text(
            text = stringResource(id = hero.nameRes),
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onTertiaryContainer
        )
        Text(
            text = stringResource(id = hero.descriptionRes),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onTertiaryContainer
        )
    }
}
