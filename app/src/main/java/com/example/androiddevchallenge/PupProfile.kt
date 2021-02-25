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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.House
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.data.PuppyRepo
import com.example.androiddevchallenge.data.pups
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.purple200
import com.example.androiddevchallenge.ui.theme.purple500
import com.example.androiddevchallenge.ui.theme.teal200
import com.example.androiddevchallenge.ui.theme.typography

@Preview(widthDp = 360, heightDp = 680)
@Composable
fun PupProfilePreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            Profile(pups[0])
        }
    }
}

@Composable
fun ProfileContainer(puppyId: String) {
    val puppy = PuppyRepo.getPuppy(puppyId.toInt())
    Surface(color = MaterialTheme.colors.background) {
        Profile(puppy)
    }
}

@Composable
fun Profile(puppy: Puppy) {
    Column {
        Row {
            Image(
                painter = painterResource(puppy.puppyDescription.imageId),
                contentDescription = "${puppy.puppyDescription.age} ${puppy.puppyDescription.breed}",
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
                    .shadow(8.dp),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {

            Text(puppy.name, style = typography.h2)
            Row(Modifier.horizontalScroll(rememberScrollState())) {
                puppy.tags.forEach {
                    Text(it, color = listOf(purple200, purple500, teal200).shuffled()[0], style = typography.subtitle1)
                    Spacer(Modifier.padding(horizontal = 8.dp))
                }
            }
            Text(
                "${puppy.puppyDescription.age} old | ${puppy.puppyDescription.sex.display} | ${puppy.puppyDescription.breed}", style = typography.subtitle2,
                modifier = Modifier.horizontalScroll(
                    rememberScrollState()
                )
            )
            Text(
                puppy.puppyDescription.description, style = typography.body1,
                modifier = Modifier.verticalScroll(
                    rememberScrollState()
                )
            )
            Column(Modifier.padding(2.dp), verticalArrangement = Arrangement.SpaceAround) {
                Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {
                    Row {
                        Icon(Icons.Filled.Call, contentDescription = "Contact Phone Number", tint = MaterialTheme.colors.secondary)
                        Spacer(Modifier.padding(8.dp))
                        Text(puppy.puppyContactDetails.contactNumber, fontWeight = FontWeight.Bold)
                    }
                    Row {
                        Icon(Icons.Filled.Email, contentDescription = "Email Address", tint = MaterialTheme.colors.secondary)
                        Spacer(Modifier.padding(8.dp))
                        Text(puppy.puppyContactDetails.email, fontWeight = FontWeight.Bold)
                    }
                    Row {
                        Icon(Icons.Filled.House, contentDescription = "Postcode", tint = MaterialTheme.colors.secondary)
                        Spacer(Modifier.padding(8.dp))
                        Text(puppy.puppyContactDetails.postcode, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
