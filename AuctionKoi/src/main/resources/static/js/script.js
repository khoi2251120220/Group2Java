// script.js

document.addEventListener("DOMContentLoaded", function() {
    const progress = document.querySelector(".progress");
    const steps = document.querySelectorAll(".step");

    let currentProgress = 0;
    const maxProgress = 100;

    function updateProgress() {
        if (currentProgress < maxProgress) {
            currentProgress += 5; // Tăng 5% mỗi lần
            progress.style.width = currentProgress + "%";

            steps.forEach((step, index) => {
                const stepThreshold = (index + 1) * 20; // Mỗi giai đoạn 20% cho 5 giai đoạn

                if (currentProgress >= stepThreshold) {
                    step.classList.add("completed");
                    step.classList.remove("actived");
                } else if (currentProgress >= (index * 20)) {
                    step.classList.add("actived");
                    step.classList.remove("completed");
                } else {
                    step.classList.remove("completed", "actived");
                }
            });
        } else {
            clearInterval(progressInterval);
        }
    }

    const progressInterval = setInterval(updateProgress, 2000);

    function showNotification(message) {
        const notification = document.createElement("div");
        notification.className = "notification";
        notification.innerText = message;
        document.body.appendChild(notification);

        setTimeout(() => {
            notification.remove();
        }, 3000);
    }
});
