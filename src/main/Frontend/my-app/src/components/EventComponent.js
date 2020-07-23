import React from "react";
import EventService from "../services/EventService";

class EventComponent extends React.Component {

    constructor(props) {
        super(props)

        this.state = {eventById: 0,
            events: []
         }
    }
    componentDidMount() {
        EventService.getEvents().then((response) => {
            this.setState({events: response.data})
        });
    }


    mySubmitHandler = (event) => {
        EventService.getEventById(this.state.eventById).then((response) => {
            this.setState({events: response.data})
        });
        event.preventDefault();
    }

    myChangeHandler = (event) => {
        this.setState({eventById: event.target.value});

    }
    render() {
        return (

            <div>
                <h1 className="text-center">EventsDTO list </h1>
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
                <table className= "table table-striped">
                    <thead>
                    <tr>
                        <td>Event ID</td>
                        <td>Event Type</td>
                        <td>Power Loss</td>
                        <td>Start Date</td>
                        <td>End Date</td>
                        <td>PowerStation ID</td>
                        <td>PowerStation Name</td>
                        <td>PowerStation Power</td>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.events.map(
                            event =>
                                <tr key ={event.id} >
                                    <td>{event.id}</td>
                                    <td>{event.eventType}</td>
                                    <td>{event.powerLoss}</td>
                                    <td>{event.startDate}</td>
                                    <td>{event.endDate}</td>
                                    <td>{event.psId}</td>
                                    <td>{event.psName}</td>
                                    <td>{event.psPower}</td>

                                </tr>
                        )
                    }
                    </tbody>
                </table>

            </div>
        )
    }

}

export default EventComponent