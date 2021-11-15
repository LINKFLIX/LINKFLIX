import { App, createApp } from 'vue';
import Sidebar from './components/Sidebar/Sidebar.vue';
import { TimelineApi } from './api/restApi';
import { Product, TimelineDto } from './types';

import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import './assets/css/base.css';

let netflixEpisodeId = window.location.pathname.split('/')[2];
const initIfChangedEpisode = () => {
  const nowId = window.location.pathname.split('/')[2];
  if (netflixEpisodeId !== nowId) {
    netflixEpisodeId = nowId;
    init();
  }
  window.setTimeout(initIfChangedEpisode, 500);
};

let products: Product[], timelines: TimelineDto[];
const init = async () => {
  timelines = await callGetTimelines();
  products = timelinesToProducts(timelines);
  const app = createApp(Sidebar, { products });
  prependToBodyEl(app);
  renderUiIfPossible();
};

const callGetTimelines = async () => {
  return await TimelineApi.getTimelines(netflixEpisodeId);
};

const timelinesToProducts = (timelines: TimelineDto[]) => {
  const result: Product[] = [];

  timelines.forEach((item) => {
    const p = result.find((p) => p.id == item.product.id);
    if (p) {
      p.timeline.push({ startTime: item.startTime });
    } else {
      item.product.imagePath =
        'https://k5a104.p.ssafy.io:8081/products/image/' +
        item.product.imagePath.split('/')[2];

      result.push({
        ...item.product,
        timeline: [{ startTime: item.startTime }],
      });
    }
  });

  return result;
};

const prependToBodyEl = (app: App) => {
  const bodyEl = document.querySelector('body');
  if (bodyEl) {
    const mountEl = document.createElement('div');
    bodyEl.prepend(mountEl);
    app.mount(mountEl);
  }
};

let netflixVideoPlayerUI: HTMLElement | null,
  toggleBtnTarget: HTMLElement | null,
  productTimelineTarget: HTMLElement | null;

let isToggleBtnRender = false,
  isProductTimelineRender = false;

const renderUiIfPossible = () => {
  netflixVideoPlayerUI = document.querySelector(
    '.watch-video--bottom-controls-container'
  );

  if (netflixVideoPlayerUI) {
    toggleBtnTarget = document.querySelector(
      'div.watch-video--bottom-controls-container > div > div > div:nth-child(3) > div > div:nth-child(3)'
    );
    if (toggleBtnTarget && !isToggleBtnRender) {
      renderToggleBtn();
      isToggleBtnRender = true;
    }

    productTimelineTarget = document.querySelector(
      'div.watch-video--bottom-controls-container > div > div > div > div > div'
    );
    if (
      productTimelineTarget &&
      productTimelineTarget.getAttribute('data-uia') === 'timeline'
    ) {
      if (!isProductTimelineRender) {
        renderProductTimeline(productTimelineTarget);
        isProductTimelineRender = true;
      }
    } else {
      isProductTimelineRender = false;
    }
  } else {
    isToggleBtnRender = false;
    isProductTimelineRender = false;
  }

  window.setTimeout(renderUiIfPossible, 100);
};

const renderToggleBtn = () => {
  const toggleBtnEl = netflixVideoPlayerUI?.querySelector(
    `#${TOGGLE_BTN_EL_ID}`
  );
  if (toggleBtnEl) return;

  const toggleBtnContainer = document.createElement('div');
  toggleBtnContainer.innerHTML = TOGGLE_BTN_EL.trim();
  toggleBtnContainer.onclick = () => {
    if (document.fullscreenElement) document.exitFullscreen();
  };
  toggleBtnTarget?.prepend(toggleBtnContainer);
};

const renderProductTimeline = (target: HTMLElement) => {
  const productTimelineElList = netflixVideoPlayerUI?.querySelectorAll(
    '[data-uia="linkflix-product-timeline"]'
  );
  if (!productTimelineElList || productTimelineElList.length > 0) return;

  const max = Number(target.getAttribute('max'));
  timelines.forEach((timeline) => {
    const now = timeStringToMills(timeline.startTime);
    const position = target.offsetWidth * (now / max);
    target.children[0].append(getProductTimelineEl(position));
  });
};

const timeStringToMills = (format: string) => {
  const secToMills = (sec: string) => {
    return Number(sec) * 1000;
  };

  const minToMills = (min: string) => {
    return Number(min) * 60 * 1000;
  };

  const hourToMills = (hour: string) => {
    return Number(hour) * 60 * 60 * 1000;
  };

  const splitted = format.split(':');
  let result = 0;
  if (splitted.length == 1) {
    result = secToMills(splitted[0]);
  } else if (splitted.length == 2) {
    result = minToMills(splitted[0]) + secToMills(splitted[1]);
  } else if (splitted.length == 3) {
    result =
      hourToMills(splitted[0]) +
      minToMills(splitted[1]) +
      secToMills(splitted[2]);
  } else {
    throw 'Invalid time format.';
  }

  return result;
};

const getProductTimelineEl = (left: number) => {
  const el = document.createElement('div');
  el.setAttribute('data-uia', 'linkflix-product-timeline');
  el.style.width = '7px';
  el.style.height = '100%';
  el.style.backgroundColor = 'rgba(6, 69, 173, 0.7)';
  el.style.boxSizing = 'border-box';
  el.style.position = 'absolute';
  el.style.left = `${left}px`;
  return el;
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
initIfChangedEpisode();
