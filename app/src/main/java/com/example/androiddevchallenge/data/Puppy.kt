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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

enum class Sex(val display: String) { MALE("Male"), FEMALE("Female") }
data class Puppy(val id: Int, val name: String, val puppyDescription: PuppyDescription, val puppyContactDetails: PuppyContactDetails, val tags: List<String>)
data class PuppyDescription(val age: String, val sex: Sex, val breed: String, val imageId: Int, val description: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam tincidunt nunc sit amet accumsan elementum. Integer condimentum velit a ex fermentum, sit amet vestibulum quam maximus. Ut luctus nisi eget mauris ornare, id suscipit enim lobortis. Sed elit ligula, suscipit sit amet augue vitae, placerat semper lacus. Proin ipsum risus, efficitur id interdum a, tincidunt sed velit.")
data class PuppyContactDetails(val postcode: String, val contactNumber: String, val email: String)

private var ids: MutableList<Int> = (0..10).shuffled() as MutableList<Int>
val tags = listOf("Feisty", "Playful", "Calm", "Intelligent", "Potty Trained", "Trick Lover", "Fast Learner", "Lovable", "Active", "Sleepy", "Daily Walks", "Weekly Walks")
val names: MutableList<String> = listOf("Shadow", "Atlas", "Lilac", "Nino", "Aja", "Rex", "Cash", "Alex", "Mocha", "Fionn", "Remi", "Luna", "Charlie", "River", "Oreo").shuffled() as MutableList<String>
val puppyDescriptions: MutableList<PuppyDescription> = listOf(
    PuppyDescription("1 month", Sex.MALE, "Shitzu", R.drawable.shitzu, "This boy is full of love and ready to give it to someone! Please get in touch as soon as possible"),
    PuppyDescription("3 months", Sex.FEMALE, "Boxer", R.drawable.boxer, "She has an amazing personality. She's super smart, and already excited by everything around. Good for a family. Get in touch."),
    PuppyDescription("1 year", Sex.MALE, "Dalmatian", R.drawable.dalmatian, "I love him and his spots! I hope you can love him as much as I do! Please get in touch, so I can see if you would be a good fit."),
    PuppyDescription("2 months", Sex.MALE, "Akita", R.drawable.akita, "He's definitely an Akita. There might be me more work involved with this breed but it is totally worth it to help them grow up. Lifelong friend. Get in touch"),
    PuppyDescription("9 months", Sex.FEMALE, "Dachshund", R.drawable.dachshund, "Sausage? Sure that would be one word to describe her. She's so many other things though! One of them being extremely adorable. Would you like to adopt? Please get in touch between 8am-6pm on weekdays 😇"),
    PuppyDescription("2 months", Sex.MALE, "Labrador", R.drawable.labrador1, "Labrador's are everyone's best friend, and as a puppy he is no exception. He is so ready to unconditionally love someone. We'd love to give him a home. Get in touch."),
    PuppyDescription("3 months", Sex.FEMALE, "German Shepherd", R.drawable.gshephard, "She's going to grow very big! But at the moment she's small and cute. And come to think of it, she'll still be cute when she gets bigger. Please get in touch quickly, she needs a good home!"),
    PuppyDescription("6 months", Sex.MALE, "Golden Retriever", R.drawable.retriever, "This retriever loves to play. Constantly. So much energy. Needs a good family to house and care for him, and that cna watch him. If that sounds like you get in touch."),
    PuppyDescription("6 months", Sex.FEMALE, "Labrador", R.drawable.labrador2, "A beautiful coat, endless personality, and a big dog heart just waiting to grow up in a loving family. There is truly nothing better! Please get in touch."),
    PuppyDescription("2 months", Sex.FEMALE, "Shiba Inu", R.drawable.shiba, "Shibas can get a little dramatic. She is no exception! She loves to play and be goofy. She's quite independent however, like a cat. Make sure you are prepared about shibas before contacting :)"),
).shuffled() as MutableList<PuppyDescription>
val puppyContactDetails: MutableList<PuppyContactDetails> = listOf(
    PuppyContactDetails("CO3 LL9", "+44 349020339", "jason@gmail.com"),
    PuppyContactDetails("LA5 6GG", "+44 649021339", "carter@hotmail.co.uk"),
    PuppyContactDetails("ST15 MR5", "+44 454345354", "jane@hey.com"),
    PuppyContactDetails("ST98 LR5", "+44 9513335474", "lora@gmail.com"),
    PuppyContactDetails("MA34 4YU", "+44 790204339", "kate@gmail.com")
).shuffled() as MutableList<PuppyContactDetails>

val pups = listOf(
    Puppy(
        id = ids.removeFirst(),
        name = names.removeFirst(),
        puppyContactDetails = puppyContactDetails.removeFirst(),
        puppyDescription = puppyDescriptions.removeFirst(),
        tags = tags.shuffled().take(3)
    ),
    Puppy(
        id = ids.removeFirst(),
        name = names.removeFirst(),
        puppyContactDetails = puppyContactDetails.removeFirst(),
        puppyDescription = puppyDescriptions.removeFirst(),
        tags = tags.shuffled().take(3)
    ),
    Puppy(
        id = ids.removeFirst(),
        name = names.removeFirst(),
        puppyContactDetails = puppyContactDetails.removeFirst(),
        puppyDescription = puppyDescriptions.removeFirst(),
        tags = tags.shuffled().take(3)
    ),
    Puppy(
        id = ids.removeFirst(),
        name = names.removeFirst(),
        puppyContactDetails = puppyContactDetails.removeFirst(),
        puppyDescription = puppyDescriptions.removeFirst(),
        tags = tags.shuffled().take(3)
    ),
    Puppy(
        id = ids.removeFirst(),
        name = names.removeFirst(),
        puppyContactDetails = puppyContactDetails.removeFirst(),
        puppyDescription = puppyDescriptions.removeFirst(),
        tags = tags.shuffled().take(3)
    ),
)
