import axios from "axios";

export default class WorkingPlaceTypeService {
  getWorkingPlaceTypes() {
    return axios.get("http://localhost:8080/api/workingPlaceTypes/getAll");
  }
}
