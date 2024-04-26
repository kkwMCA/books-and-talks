import Post from "../post/Post";
import Share from "../share/Share";
import "./feed.css";
// import { Posts } from "../../dummyData";
import React, { useState, useEffect } from "react";



export default function Feed() {

  const url = "http://localhost:8081/getAllPost";
  const [data, setData] = useState([]);

  const fetchInfo = () => {
    return fetch(url)
      .then((res) => res.json())
      .then((d) => setData(d))
  }


  useEffect(() => {
    fetchInfo();
  }, []);
  return (
    <div className="feed">
      <div className="feedWrapper">
        <Share />
        {data.map((p) => (
          <Post key={p.} post={p} />
        ))}
      </div>
    </div>
  );
}
