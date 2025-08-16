import React from "react";

function Guest(){
    return(
        <div>
            <h2>Welcome Guest!</h2>
            <p>Here are the available flights:</p>
           <ul>
            <li>Flight A - 10:00 AM</li>
            <li>Flight B - 01:30 PM</li>
            <li>Flight C - 07:45 PM</li>
          </ul>
          <p>Please login to book a ticket.</p>
        </div>
    );
}

export default Guest;