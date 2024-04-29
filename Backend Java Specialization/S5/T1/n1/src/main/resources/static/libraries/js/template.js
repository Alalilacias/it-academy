document.getElementById('showPasswordToggle').addEventListener('click', function() {
    var passwordInput = document.getElementById('loginPassword');
    if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
    } else {
        passwordInput.type = 'password';
    }
});
document.addEventListener('hidden.bs.modal', function (event) {
    var modal = event.target;
    var modalContent = modal.querySelector('.modal-body');
    var alertElement = modalContent.querySelector('.alert');
    if (alertElement) {
        // Remove the alert element from the modal's content area
        alertElement.remove();
    }
});
function redirectToGoogle(modalId) {
    var modalContent = document.querySelector('#' + modalId + ' .modal-body');

    var existingAlert = modalContent.querySelector('.alert');
    if (existingAlert) {
        return;
    }

    var alertElement = document.createElement('div');
    alertElement.classList.add('alert', 'alert-warning', 'alert-dismissible', 'fade', 'show');
    alertElement.setAttribute('role', 'alert');
    alertElement.innerHTML = `
        Google login is currently not implemented. We apologize for the inconvenience. Please register/login using the regular methods.
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    `;

    modalContent.appendChild(alertElement);
}