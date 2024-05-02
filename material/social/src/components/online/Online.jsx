import "./online.css";

export default function Online({user2}) {
  return (
    <li className="rightbarFriend">
      <div className="rightbarProfileImgContainer">
        <img className="rightbarProfileImg" src={user2.profilePicture} alt="" />
        {/* <span className="rightbarOnline"></span> */}
      </div>
      <span className="rightbarUsername">{user2.username}</span>
    </li>
  );
}
