import React from "react";


function EvenPlayers({players}){


    const [,second,fourth,sixth]=players;
    return(
        <div>
            <ul>
                <li>Second:{second}</li>
                <li>Fourth:{fourth}</li>
                <li>Sixth:{sixth}</li>
            </ul>
        </div>
    );
}

export default EvenPlayers;