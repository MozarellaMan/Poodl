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
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.data.pups
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.purple200
import com.example.androiddevchallenge.ui.theme.purple500
import com.example.androiddevchallenge.ui.theme.teal200
import com.example.androiddevchallenge.ui.theme.typography

@Preview(widthDp = 360, heightDp = 680)
@Composable
fun PupSwiperPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            Row(modifier = Modifier.padding(8.dp), horizontalArrangement = Arrangement.Center) {
                PuppyCardContainer(0)
            }
        }
    }
}

@Composable
fun PuppyCardContainer(currentPuppy: Int? = null) {
    Column(verticalArrangement = Arrangement.Center) {
        Row {
            if (currentPuppy == null) {
                Text("No more puppies! 😭")
            } else {
                PuppyCard(pups[currentPuppy], modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Composable
fun PuppyCard(puppy: Puppy, modifier: Modifier) {
    Column(modifier) {
        Row {
            Image(
                painter = painterResource(puppy.puppyDescription.imageId),
                contentDescription = "${puppy.puppyDescription.age} ${puppy.puppyDescription.breed}",
                modifier = Modifier
                    .height(460.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Text(puppy.name, style = typography.h4)
        Text("${puppy.puppyDescription.age} old | ${puppy.puppyDescription.sex.display} | ${puppy.puppyDescription.breed}", style = typography.h5, modifier = Modifier.horizontalScroll(rememberScrollState()))
        Row(Modifier.horizontalScroll(rememberScrollState())) {
            puppy.tags.forEach {
                Text(it, color = listOf(purple200, purple500, teal200).shuffled()[0], style = typography.h6)
                Spacer(Modifier.padding(horizontal = 8.dp))
            }
        }
        Text("${puppy.puppyDescription.description.take(60)}...", style = typography.body1)
    }
}
