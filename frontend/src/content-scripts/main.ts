import { createApp, DefineComponent } from 'vue';
import Popup from './Popup.vue';
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../assets/css/base.css';


// var config = {
//   attributes: true,
//   childList: true,
//   characterData: true,
// };

// var observer = new MutationObserver(function(mutations) {
//   console.log(mutations);
//   console.log(1);
//   mutations.forEach(function(mutation) {
//     console.log(mutation);
//     console.log('찾음');
//   });
// });
var uiStatus = false;
function addObserverIfDesiredNodeAvailable() {
  var target = document.querySelectorAll(
    '.watch-video--bottom-controls-container'
  )[0];
  if (!target) {
    //The node we need does not exist yet.
    //Wait 500ms and try again
    uiStatus = false;
    console.log('not found');
  } else if (uiStatus == false) {
    console.log('found');
    uiStatus = true;
    const MOUNT_EL_ID = 'linkFlix';

    let mountEl = document.getElementById(MOUNT_EL_ID);
    if (mountEl) {
      mountEl.innerHTML = '';
    }
    mountEl = document.createElement('div');
    mountEl.setAttribute('id', MOUNT_EL_ID);
    target.appendChild(mountEl);
    const vm = createApp(Popup).mount(mountEl);
    chrome.runtime.onMessage.addListener((message) => {
      if (message.toggleVisible) {
        (vm as any).visible = !(vm as any).visible;
      }
    });
    // observer.observe(target, config);
  }

  window.setTimeout(addObserverIfDesiredNodeAvailable, 500);
  return;
}

addObserverIfDesiredNodeAvailable();
