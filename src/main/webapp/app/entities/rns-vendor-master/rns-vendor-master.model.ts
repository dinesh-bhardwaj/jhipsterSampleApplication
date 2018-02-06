import { BaseEntity } from './../../shared';

export class RNS_VENDOR_MASTER implements BaseEntity {
    constructor(
        public id?: number,
        public vENDORCODE?: string,
        public vENDORMASTERCODE?: string,
        public vENDORNAME?: string,
        public vENDORUSERID?: number,
        public uSERNAME?: string,
        public eMAIL?: string,
        public mOBILENUMBER?: string,
    ) {
    }
}
