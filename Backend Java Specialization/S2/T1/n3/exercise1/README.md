# Assignment Instructions
We will try to make a simple model of what the database needed for Spotify would look like.

There are two types of users: free and premium.

We keep a unique identifier for each user:
- Email
- Password.
- Username.
- Date of birth.
- Sex
- Country
- Postal code.

Premium users make subscriptions. 
The necessary data that will need to be saved for each subscription are:
- Subscription start date.
- Service renewal date.
- A form of payment, which can be via credit card or PayPal.

For credit cards, we save:
- The card number
- Month and year of expiry and, 
- The security code.
- We save the PayPal username of users who pay with PayPal.

We are interested in keeping a record of all the payments that a premium user has made during the period they are subscribed to.
From each payment we save:
- The date.
- An order number (which is unique).
- A total

A user can create many playlists. From each playlist we save:
- A title
- The number of songs it contains.
- A unique identifier.
- A creation date.
- When a user deletes a playlist it is not deleted from the system, but is marked as deleted. In this way the user can recover their playlists in case they have deleted them by mistake.
- It is necessary to store the date on which the playlist was marked as deleted. 
- We can say that there are two types of playlists: active and deleted.

A playlist that is active can be shared with other users, this means that other users can add songs to it.
- In a shared list, we are interested in knowing:
- which user added each song
- On what date.
- A song can only belong to a single album.
- An album can contain many songs.
- An album has been published by a single artist.
- An artist may have released many albums.

We save a unique identifier for each song:
- A title
- A duration
- The number of times it has been played by Spotify users.

For each album we save a unique identifier:
- title
- Year of publication
- An image with the cover.

We keep a unique identifier for each artist:
- First name.
- An image of the artist

A user can follow many artists.

An artist may be related to other artists who make similar music. So that Spotify can show us a list of artists related/from the artists we like.

We are also interested in keeping track of a user's favorite albums and songs. A user can select many albums and many songs as favorites.