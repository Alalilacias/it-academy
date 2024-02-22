# Assignment Instructions
We'll try to make a simple model of what the database for a scaled-down version of YouTube would look like.

We keep a unique identifier for each user, as well as:
- Email
- Password.
- Username.
- Date of birth.
- Sex
- Country
- Postal code.

As the user publishes videos, we save a unique identifier for each video, as well as:
- A title
- A description
- A size
- The name of the video file.
- Video length.
- A thumbnail.
- The number of reproductions.
- The number of likes.
- The number of dislikes.
- A video can have three different states: public, hidden, and private.
- A video can have many tags. A tag is identified by a unique identifier and a tag name.
- The company is interested in saving who the user who publishes the video is and the date/time when they did it.

A user can create a channel. A channel has a unique identifier, as well as:
- Name
- Description
- Creation date.

A user can subscribe to other users' channels.

A user can like or dislike a video only once.

It will be necessary to keep a record of the users who have liked and disliked a certain video and at what date/time they did so.

A user can create playlists with the videos they like. Each playlist has a unique identifier, as well as:
- Name
- Creation date.
- Status indicating that it can be public or private.

A user can write comments on a given video. Each comment is identified by a unique identifier, as well as:
- The text of the comment.
- The date/time it was performed.

A user can mark a comment as like or dislike. It will be necessary to keep a record of:
- The users who marked a comment as like/dislike
- At what date/time they did so.