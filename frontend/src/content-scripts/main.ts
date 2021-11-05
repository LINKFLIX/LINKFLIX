import { App, createApp } from 'vue';
import Sidebar from '../components/Sidebar/Sidebar.vue';

import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../assets/css/base.css';

let uiStatus = false;

const init = () => {
  const app = createApp(Sidebar);
  prependToBodyElement(app);
  renderToggleButton();
};

const prependToBodyElement = (app: App) => {
  const bodyEl = document.querySelector('body');
  if (bodyEl) {
    const mountEl = document.createElement('div');
    bodyEl.prepend(mountEl);
    app.mount(mountEl);
  }
};

const renderToggleButton = () => {
  renderToggleBtnIfNodeAvailable();
};

const renderToggleBtnIfNodeAvailable = () => {
  const toggleBtnEl = document.getElementById(TOGGLE_BTN_EL_ID);
  const target = document.querySelectorAll(
    '.watch-video--bottom-controls-container > div > div > div:nth-child(3) > div > div:nth-child(3)'
  )[0];

  if (toggleBtnEl) {
    uiStatus = false;
  } else if (!target) {
    uiStatus = false;
  } else if (!uiStatus) {
    uiStatus = true;

    const toggleBtnEl = document.createElement('div');
    toggleBtnEl.innerHTML = TOGGLE_BTN_EL.trim();
    target.prepend(toggleBtnEl);
  }

  window.setTimeout(renderToggleBtnIfNodeAvailable, 100);
  return;
};

const TOGGLE_BTN_EL_ID = 'linkflix-toggle-btn';
const TOGGLE_BTN_EL = `
<button
  id="${TOGGLE_BTN_EL_ID}"
  class="${TOGGLE_BTN_EL_ID} p-0"
  type="button"
  data-bs-toggle="offcanvas"
  data-bs-target="#offcanvasRight"
  aria-controls="offcanvasRight"
>
  <div
    class="d-flex justify-content-center align-items-center"
    style="width: 4rem; height: 4rem"
  >
    <svg
      xmlns="http://www.w3.org/2000/svg"
      fill="currentColor"
      class="bi bi-cart3"
      viewBox="0 0 16 16"
    >
      <path
        d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"
      />
    </svg>
  </div>
</button>
`;

init();
