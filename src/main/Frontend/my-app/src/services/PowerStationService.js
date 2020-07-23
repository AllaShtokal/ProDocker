import axios from 'axios'

const STATIONS_REST_API_URL = 'http://localhost:9966/api/v1/stations';

class PowerStationService {

    getStations() {
        return axios.get(STATIONS_REST_API_URL);
    }

    getStationById(id) {
        return axios.get(STATIONS_REST_API_URL + '/' + id);
    }


}

export default new PowerStationService();