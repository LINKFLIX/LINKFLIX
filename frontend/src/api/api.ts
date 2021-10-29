import axios, { AxiosResponse } from 'axios';
import { TimelineDto } from '../types';

const instance = axios.create({
  baseURL: 'http://k5a104.p.ssafy.io:8080/',
  timeout: 15000,
});

const responseBody = (response: AxiosResponse) => response.data;

const requests = {
  get: (url: string) => instance.get(url).then(responseBody),
  post: (url: string, body: {}) => instance.post(url, body).then(responseBody),
  put: (url: string, body: {}) => instance.put(url, body).then(responseBody),
  delete: (url: string) => instance.delete(url).then(responseBody),
};

export const TimelineApi = {
  getTimelines: (episodeId: string): Promise<TimelineDto[]> =>
    requests.get(`timeline/${episodeId}`),
};
