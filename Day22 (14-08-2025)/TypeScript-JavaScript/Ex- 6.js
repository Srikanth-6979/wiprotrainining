
const movie = {
    movieName: "RRR",
    movieLanguage: "TELUGU",
    imdbRating: 9.0
};
console.log(`${movie.movieName} - ${movie.movieLanguage} - ${movie.imdbRating}`);


const { movieName, movieLanguage, imdbRating } = movie;

console.log("Movie Name:", movieName);
console.log("Language:", movieLanguage);
console.log("IMDB Rating:", imdbRating);
