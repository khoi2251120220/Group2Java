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
                const line = document.getElementById(`phase-${index + 1}`);

                if (currentProgress >= stepThreshold) {
                    step.classList.add("completed");
                    step.classList.remove("actived");
                    line.classList.add("completed");
                    line.classList.remove("actived");
                } else if (currentProgress >= (index * 20)) {
                    step.classList.add("actived");
                    step.classList.remove("completed");
                    line.classList.add("actived");
                    line.classList.remove("completed");
                } else {
                    step.classList.remove("completed", "actived");
                    line.classList.remove("completed", "actived");
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

    const dateElements = document.querySelectorAll(".date");

    dateElements.forEach(dateElement => {
        const formattedDate = formatDate(dateElement.innerText);
        dateElement.innerText = formattedDate;
    });

    function formatDate(inputDate) {
        const date = new Date(inputDate);

        if (isNaN(date)) {
            return 'Invalid date';
        }

        const day = String(date.getDate()).padStart(2, '0');
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const year = date.getFullYear();
        const hour = String(date.getHours()).padStart(2, '0');
        const minute = String(date.getMinutes()).padStart(2, '0');

        return `${day}/${month}/${year} ${hour}:${minute}`;
    }
});
