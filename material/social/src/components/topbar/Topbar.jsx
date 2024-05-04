import "./topbar.css";
import { Search, Person, Chat, Notifications } from "@material-ui/icons";
import React, { useState, useEffect } from "react";
import axios from "axios";

export default function Topbar() {

  const [community, setCommunity] = useState(null);


 
  return (
    <div className="topbarContainer">
      <div className="topbarLeft">
        <span className="logo">Books & Talks</span>
      </div>
      <div className="topbarCenter">
        <div className="searchbar">
          <Search className="searchIcon" />
       
          <input
            placeholder="Search for Community, Books, Video, Pdf"
            className="searchInput"
            onChange={(e) => { setCommunity(e.target.value) }}
            value={community}
          />
          {/* <button type="submit" onClick={(e) => handleForm(e)}>Add Post</button> */}
         
        </div>
      </div>
      <div className="topbarRight">
        <div className="topbarLinks">
          <span className="topbarLink">Communities</span>
          <span className="topbarLink">Comments</span>
        </div>
        <div className="topbarIcons">
          {/* <div className="topbarIconItem">
            <Person />
            <span className="topbarIconBadge">1</span>
          </div> */}
          {/* <div className="topbarIconItem">
            <Chat />
            <span className="topbarIconBadge">2</span>
          </div> */}
          <div className="topbarIconItem">
            <Notifications />
            <span className="topbarIconBadge">1</span>
          </div>
        </div>
        <img src="/assets/person/1.jpeg" alt="" className="topbarImg"/>
      </div>
    </div>
  );
}
