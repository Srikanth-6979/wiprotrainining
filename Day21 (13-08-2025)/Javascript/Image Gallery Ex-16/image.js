const images = [
    "https://assets.khetigaadi.com/new-tractor/Massey-Ferguson-1035-DI-MAHASHAKTI1734590610_C2yLpSEaJ9.png",
    "https://media.istockphoto.com/id/1029301814/photo/farmer-ploughing-field.jpg?s=612x612&w=0&k=20&c=DUfDbLJ_gpkdPJZu3Nu3_Y_wdB64MP1lAoNtus1ewXQ=",
    "https://i.pinimg.com/736x/fd/89/cc/fd89cce0b421b6b4d37959ffc4422efc.jpg",
    "https://c4.wallpaperflare.com/wallpaper/562/418/462/african-animals-jungle-lion-zebra-giraffe-elephants-flamingo-art-wallpaper-hd-1920%C3%971200-wallpaper-preview.jpg",
    "https://media.istockphoto.com/id/586701892/photo/sunrise-at-the-mountain-with-trees-and-flying-birds.jpg?s=612x612&w=0&k=20&c=P-NFeRTIPAEbReqwaamCLpYAZb8FYMPSslHO2geaexc=",
];

let currentIndex = 0;

function updateImage() {
    document.getElementById("galleryImage").src = images[currentIndex];
}
function nextImage() {
    currentIndex = (currentIndex + 1) % images.length;
    updateImage();
}

function prevImage() {
    currentIndex = (currentIndex - 1 + images.length) % images.length;
    updateImage();
}

window.onload = updateImage;
