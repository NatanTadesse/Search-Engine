# Book Search Engine

This project is a simple book search engine that allows users to find and rate books based on specific terms. The project includes classes and interfaces to represent books and other media, create an inverted index, and interact with users through a command-line interface.

## Features

- Load books from a specified directory
- Create an inverted index of words from the books
- Search for books containing specific terms
- Add ratings to books
- Display search results and ratings

## Classes and Interfaces

### `Book`
Represents a book and implements the `Media` interface and `Comparable` interface. Provides methods to get the title, authors, ratings, and words associated with the book. Allows setting a query for ranking purposes.

### `InvertedIndex`
Creates an index of words from a list of `Media` objects. Provides methods to build the index and search for media containing specific terms.

### `Media`
An interface to represent various types of media (movies, books, TV shows, songs, etc.). Defines methods to get the title, artists, ratings, and words associated with the media.

### `SearchClient`
Allows users to find and rate books within a specified directory. Provides a command-line interface for users to search for books, rate books, or quit the program.

## Usage

1. **Clone the repository:**
    ```sh
    git clone https://github.com/your-username/book-search-engine.git
    cd book-search-engine
    ```

2. **Compile the Java files:**
    ```sh
    javac *.java
    ```

3. **Run the `SearchClient` class:**
    ```sh
    java SearchClient
    ```

4. **Follow the on-screen prompts to search for books, rate books, or quit the program.**
