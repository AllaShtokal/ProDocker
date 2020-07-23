import React from 'react';
import './App.css';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
import EventComponent from "./components/EventComponent";
import PowerStationComponent from "./components/PowerStationComponent";
import ContactComponent from "./components/ContactComponent";


function App() {
    return (
        <Router>
            <div className="App">
                <h1>Power Station Application</h1>
                <ul className="header">
                    <li><Link to="/component">Events</Link></li>
                    <li><Link to="/stations">Stations</Link></li>
                    <li><Link to="/contact">Contact</Link></li>
                </ul>
                <div className="content">
                    <Route exact path="/component" component={EventComponent}/>
                    <Route path="/stations" component={PowerStationComponent}/>
                    <Route path="/contact" component={ContactComponent}/>

                </div>


            </div>
        </Router>
    );
}

export default App;
