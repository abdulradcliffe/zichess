# zichess

ZiChess is a free chess game engine. you can use this project in your game and build any kind of UI (Web/Mobile App, Desktop App) to develop a chess game. This Engine Corrently Supports following features

* select a piece to see where it can go? (Eligible Squares for a piece in a particular game position)
* Move the piece to a selected target position
* Whenever you move a piece you will get a result of that move which can be any of the following
  * WHITE_STALEMATE (means the white king is stalemate now)
  * BLACK_STALEMATE (means the black king is stalemate now)
  * WHITE_IN_CHECK (means the white king in check now and its white's turn to play now)
  * BLACK_IN_CHECK (means the black king in check now and its black's turn to play now)
  * WHITE_WON_CHECKMATE (Means the white side won the game by checkmate)
  * BLACK_WON_CHECKMATE (Means the black side won the game by checkmate)
  * IN_PROGRESS (means the game is still in progress)

* As of now Auto Queen is supported. whenever a pawn is promoted. it is always promoted to a queen. user can not select which piece he wants to promote
* En passant is not supported in this model as of now
* King Castle move is not supported as of now

# Usage
To use this You can download the project and copy paste the classes in a package
* When the game starts. create an object of ChessBoard class
* Whenever user selectes a piece to see the available squares. call the chessBoard.getPiece(x, y) it will return you the piece on that position
* then call the chessBoard.availablePositionFor(piece). this will return you the available positions for that piece
* Then when the user selects a target square , call the chessBoard.play(piece, targetX, targetY), Note that the position indexing starts from 1 not from 0.

