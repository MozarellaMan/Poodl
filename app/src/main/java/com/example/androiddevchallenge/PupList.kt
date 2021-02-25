/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.data.pups
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.purple200
import com.example.androiddevchallenge.ui.theme.purple500
import com.example.androiddevchallenge.ui.theme.teal200
import com.example.androiddevchallenge.ui.theme.typography

@Preview(widthDp = 360, heightDp = 680)
@Composable
fun PupListItemPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            PuppyList(null)
        }
    }
}

@Composable
fun PuppyList(navController: NavController?) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(pups) {
            PupListItem(navController!!, it)
        }
    }
}

@Composable
fun PupListItem(navController: NavController, puppy: Puppy) {
    Row(
        Modifier.padding(16.dp).clickable(
            onClick = {
                navController.navigate("puppy/${puppy.id}")
            }
        ),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column {
            Image(
                painter = painterResource(puppy.puppyDescription.imageId),
                contentDescription = "${puppy.puppyDescription.age} ${puppy.puppyDescription.breed}",
                modifier = Modifier
                    .size(80.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(Modifier.padding(8.dp))
        Column {
            Text(puppy.name, style = typography.subtitle1)
            Row(Modifier.horizontalScroll(rememberScrollState())) {
                puppy.tags.forEach {
                    Text(it, color = listOf(purple200, purple500, teal200).shuffled()[0], style = typography.subtitle2)
                    Spacer(Modifier.padding(horizontal = 8.dp))
                }
            }
            Text(
                "${puppy.puppyDescription.age} old | ${puppy.puppyDescription.sex.display} | ${puppy.puppyDescription.breed}", style = typography.body1,
                modifier = Modifier.horizontalScroll(
                    rememberScrollState()
                )
            )
            Text("${puppy.puppyDescription.description.take(25)}...", style = typography.body2)
        }
    }
}
