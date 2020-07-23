import axios from 'axios'

const EVENTS_REST_API_URL_EVENTS = 'http://localhost:9966/api/v1/events/eventsdto';

class EventService {

    getEvents() {
        return axios.get(EVENTS_REST_API_URL_EVENTS);
    }

    getEventById(id) {
        return axios.get(EVENTS_REST_API_URL_EVENTS + '/' + id);
    }


}

export default new EventService();