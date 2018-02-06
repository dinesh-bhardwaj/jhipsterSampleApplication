import { BaseEntity } from './../../shared';

export class RNS_CRM_REQUEST_MASTER implements BaseEntity {
    constructor(
        public id?: number,
        public cRMCODE?: number,
        public bUYERCODE?: string,
        public bUYERNAME?: string,
    ) {
    }
}
