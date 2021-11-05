import { createApp } from 'vue';
import Popup from './Popup.vue';

import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../assets/css/base.css';

var uiStatus = false;
function addObserverIfDesiredNodeAvailable() {
  var target = document.querySelectorAll(
    '.watch-video--bottom-controls-container > div > div > div:nth-child(3) > div > div:nth-child(3)'
  )[0];
  if (!target) {
    uiStatus = false;
  } else if (uiStatus == false) {
    uiStatus = true;
    const MOUNT_EL_ID = 'linkFlix';

    let mountEl = document.getElementById(MOUNT_EL_ID);
    if (mountEl) {
      mountEl.innerHTML = '';
    }
    mountEl = document.createElement('div');
    mountEl.setAttribute('id', MOUNT_EL_ID);
    target.prepend(mountEl);
    const vm = createApp(Popup).mount(mountEl);
    chrome.runtime.onMessage.addListener((message) => {
      if (message.toggleVisible) {
        (vm as any).visible = !(vm as any).visible;
      }
    });
  }

  window.setTimeout(addObserverIfDesiredNodeAvailable, 100);
  return;
}

addObserverIfDesiredNodeAvailable();
