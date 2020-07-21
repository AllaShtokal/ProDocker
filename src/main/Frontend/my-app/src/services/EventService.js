import axios from 'axios'
const EVENTS_REST_API_URL = 'http://localhost:9966/api/v1/events/eventsdto';

class EventService {

    getEvents(){
        return axios.get(EVENTS_REST_API_URL);
    }

    getEventById(id){
        console.log('http://localhost:9966/api/v1/events/eventsdto/' + id )
        return axios.get('http://localhost:9966/api/v1/events/eventsdto/' + id);
    }



}

export default  new EventService();