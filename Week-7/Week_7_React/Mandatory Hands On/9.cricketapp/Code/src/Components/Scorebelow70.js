import React from "react";

function Scorebelow70({players}){

    const filtered=players.filter(item=>item.score<70);
    return(
        <div>
            {filtered.map((item,index)=>(
              <li key={index}>Mr.{item.name}<span>{item.span}</span></li>
            ))}
        </div>
    );
}

export default Scorebelow70;