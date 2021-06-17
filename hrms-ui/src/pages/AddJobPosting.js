import React, { useState, useEffect } from "react";
import JobPositionService from "../services/JobPositionService";
import CityService from "../services/CityService";
import WorkingPlaceTypeService from "../services/WorkingPlaceTypeService";
import WorkingTimeTypeService from "../services/WorkingTimeTypeService";

import {
  Button,
  Container,
  Form,
  Grid,
} from "semantic-ui-react";
import { useFormik } from "formik";
import * as Yup from "yup";

export default function AddJobPosting() {
  const [jobPositions, setJobPositions] = useState([]);
  const [cities, setCities] = useState([]);
  const [workingPlaceTypes, setWorkingPlaceTypes] = useState([]);
  const [workingTimeTypes, setWorkingTimeTypes] = useState([]);

  useEffect(() => {
    let jobPositionService = new JobPositionService();
    jobPositionService
      .getJobPositions()
      .then((result) => setJobPositions(result.data));

    let cityService = new CityService();
    cityService.getCities().then((result) => setCities(result.data.data));

    let workingPlaceTypeService = new WorkingPlaceTypeService();
    workingPlaceTypeService
      .getWorkingPlaceTypes()
      .then((result) => setWorkingPlaceTypes(result.data.data));

    let workingTimeTypeService = new WorkingTimeTypeService();
    workingTimeTypeService
      .getWorkingTimeTypes()
      .then((result) => setWorkingTimeTypes(result.data.data));
  }, []);

  ///////////////////////////////////////////////

  const {
    values,
    errors,
    onBlur,
    setFieldValue,
    dirty,
    isSubmitting,
    handleSubmit,
    handleReset,
    handleChange,
    handleBlur,
  } = useFormik({
    initialValues: {
      advertTitle: "",
      description: "",
    },

    validationSchema: Yup.object({
      advertTitle: Yup.string().required("İlan başlığı zorunludur."),
      description: Yup.string().required("Açıklama  zorunludur."),
      numberOfOpenPosition: Yup.string().required("Eleman sayısı giriniz."),
      jobPosition: Yup.number().required("Bir pozisyon seçiniz."),
      city: Yup.number().required("Bir şehir seçiniz. "),
      workingPlaceType: Yup.number().required("Bir çalışma yeri seçiniz."),
      workingTimeType: Yup.number().required("Bir çalışma zamanı seçiniz."),
      applicationDeadline: Yup.date().required("Son başvuru tarihi seçiniz."),
      maxSalary : Yup.number().required("Maksimum maaş değerini giriniz."),
      minSalary : Yup.number().required("Minimum maaş değerini giriniz."),

    }),

    onSubmit: (formData) => {
      console.log(formData);
    },
  });

  ///////////////////////////////////////////////

  const jobPositonOptions = jobPositions.map((jobPosition) => ({
    key: jobPosition.id,
    text: jobPosition.title,
    value: jobPosition.id,
  }));

  const cityOptions = cities.map((city) => ({
    key: city.cityId,
    text: city.cityName,
    value: city.cityId,
  }));

  const workingPlaceTypeOptions = workingPlaceTypes.map((workingPlaceType) => ({
    key: workingPlaceType.id,
    text: workingPlaceType.workingPlaceName,
    value: workingPlaceType.id,
  }));

  const workingTimeTypeOptions = workingTimeTypes.map(workingTimeType=>({
      key:workingTimeType.id,
      text:workingTimeType.workingTimeName,
      value:workingTimeType.id
  }))

  return (
    <Container>
      <h2>İş İlanı Yayınla </h2>
      <Form onSubmit={handleSubmit}>
        <Grid>
          <Grid.Row>
            <Grid.Column width="14">
              <Form.Input
                id="advertTitle"
                type="text"
                label="İlan Başlığı"
                value={values.advertTitle}
                error={errors.advertTitle}
                onChange={handleChange}
              ></Form.Input>
            </Grid.Column>
          </Grid.Row>

          <Grid.Row>
            <Grid.Column width="7">
              <Form.Select
                id="jobPosition"
                onChange={(fieldName, data) =>
                  setFieldValue("jobPosition", data.value)
                }
                value={values.jobPosition}
                options={jobPositonOptions}
                label="Pozisyon"
                placeholder="Pozisyon Seçiniz"
                search
                selection
                error={errors.jobPosition}
              ></Form.Select>

              <Form.Input
                id="applicationDeadline"
                type="date"
                label="Son Başvuru Tarihi"
                error={errors.applicationDeadline}
                onChange={handleChange}
                onBlur={handleBlur}
                value={values.applicationDeadline}
                fluid
              ></Form.Input>

              <Form.Input
                type="number"
                placeholder="Örn: 3000"
                id="minSalary"
                label="Minimum Maaş"
                onChange={handleChange}
                error={errors.minSalary}
              />
              <Form.Select
                id="workingTimeType"
                label="Çalışma Zamanı"
                onChange={(fieldName, data) =>
                    setFieldValue("workingTimeType", data.value)
                  }
                  onBlur={onBlur}
                  value={values.workingTimeType}
                  options={workingTimeTypeOptions}
                  placeholder="Çalışma Zamanı Seçiniz"
                  search
                  selection
                  error={errors.workingTimeType}
              ></Form.Select>
            </Grid.Column>

            <Grid.Column width="7">
              <Form.Select
                id="city"
                onBlur={onBlur}
                value={values.cities}
                options={cityOptions}
                onChange={(fieldName, data) =>
                    setFieldValue("city", data.value)
                  }
                label="Şehir"
                placeholder="Şehir Seçiniz"
                search
                selection
                error={errors.city}
              ></Form.Select>

              <Form.Input
                type="text"
                placeholder="Örn:1,2,3"
                name="numberOfOpenPosition"
                label="Alınacak Eleman Sayısı"
                onChange={handleChange}
                error={errors.numberOfOpenPosition}
              />
              <Form.Input
                type="number"
                placeholder="Örn: 5000"
                id="maxSalary"
                label="Maksimum Maaş"
                onChange={handleChange}
                error={errors.maxSalary}
                fluid
              />
              <Form.Select
                id="workingPlaceType"
                onChange={(fieldName, data) =>
                  setFieldValue("workingPlaceType", data.value)
                }
                onBlur={onBlur}
                value={values.workingPlaceType}
                options={workingPlaceTypeOptions}
                label="Çalışma Yeri"
                placeholder="Çalışma Yeri Seçiniz"
                search
                selection
                error={errors.workingPlaceType}
              ></Form.Select>
            </Grid.Column>
          </Grid.Row>
          <Grid.Row>
            <Grid.Column width="14">
              <Form.TextArea
                type="text"
                placeholder="Açıklama"
                id="description"
                label="Açıklama"
                onChange={handleChange}
                error={errors.description}
              />
            </Grid.Column>
          </Grid.Row>
        </Grid>

        <Button primary type="submit" disabled={!dirty || isSubmitting} style={{marginTop:"1.5em"}}>
          Yayınla
        </Button>
      </Form>
    </Container>
  );
}
