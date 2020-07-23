import React from "react";
import PowerStationService from "../services/PowerStationService";

class PowerStationComponent extends React.Component {

    constructor(props) {
        super(props)

        this.state = {
            stationById: 0,
            stations: []
        }
    }

    componentDidMount() {
        PowerStationService.getStations().then((response) => {
            this.setState({stations: response.data})
        });
    }


    mySubmitHandler = (station) => {
        PowerStationService.getStationById(this.state.stationById).then((response) => {
            this.setState({stations: response.data})
        });
        station.preventDefault();
    }

    myChangeHandler = (station) => {
        this.setState({stationById: station.target.value});

    }

    render() {
        return (

            <div>
                <h1 className="text-center">PowerStations list </h1>
                <div>
                    <form onSubmit={this.mySubmitHandler}>
                        <h1> {this.state.eventById}</h1>
                        <p>Enter your id:</p>
                        <input
                            type='number'
                            onChange={this.myChangeHandler}
                        />
                        <input
                            type='submit'
                        />
                    </form>
                </div>
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <td>PowerStation ID</td>
                        <td>PowerStation Name</td>
                        <td>PowerStation Power</td>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.stations.map(
                            station =>
                                <tr key={station.id}>
                                    <td>{station.id}</td>
                                    <td>{station.name}</td>
                                    <td>{station.power}</td>

                                </tr>
                        )
                    }
                    </tbody>
                </table>

            </div>
        )
    }

}

export default PowerStationComponent